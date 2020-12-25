using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc.Authorization;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using PasswordApp.Data;
using PasswordApp.Data.Repositories;
using PasswordApp.Web.Services;
using PasswordApp.Web.Services.Contracts;

namespace PasswordApp.Web
{
    public class Startup
    {
        public IConfiguration Configuration { get; }

        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            //TODO: add PasswordDbContext in the dependency injection container

            services.AddDefaultIdentity<User>(options => { options.SignIn.RequireConfirmedAccount = false;
            options.UseSqlServer(Configuration.GetConnectionString("DefaultConnection"));})
                .AddEntityFrameworkStores<PasswordDbContext>();
                

            //TODO: do not forget to include the filter configuration in the assignment
            services.AddControllersWithViews(options =>
            {
                //TODO: add filter
                var policy = new AuthorizationPolicy();
                options.Filters.Add(new AuthorizeFilter(policy));
            });
            services.AddRazorPages();
            services.Configure<EncryptionSettings>(Configuration.GetSection("Encryption"));
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }
            app.UseHttpsRedirection();

            app.UseRouting();

            app.UseAuthentication();
            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
                endpoints.MapRazorPages();
            });
        }
    }
}
