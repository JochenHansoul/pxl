using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace PropertyesAndButton
{
    public partial class MainPage : ContentPage
    {
        private Color _backgroundColorErrorLabel;
        public MainPage()
        {
            InitializeComponent();
            _backgroundColorErrorLabel = errorLabel.BackgroundColor;
        }

        public void ChangeColorErrorLabel(object sender, EventArgs e)
        {
            errorLabel.BackgroundColor = errorLabel.BackgroundColor == _backgroundColorErrorLabel
                ? Color.Red
                : _backgroundColorErrorLabel;
        }
    }
}
