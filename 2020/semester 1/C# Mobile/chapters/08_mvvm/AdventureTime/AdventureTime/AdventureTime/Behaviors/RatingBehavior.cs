using Xamarin.Forms;

namespace AdventureTime.Behaviors
{
    public class RatingBehavior : Behavior<Entry>
    {
        protected override void OnAttachedTo(Entry entry)
        {
            entry.TextChanged += OnEntryTextChanged;
            base.OnAttachedTo(entry);
        }

        protected override void OnDetachingFrom(Entry entry)
        {
            entry.TextChanged -= OnEntryTextChanged;
            base.OnDetachingFrom(entry);
        }

        private void OnEntryTextChanged(object sender, TextChangedEventArgs e)
        {
            bool isValid = int.TryParse(e.NewTextValue, out int result);
            ((Entry)sender).TextColor = isValid && (result > 0 && result < 100) ? Color.Default : Color.Red;
            // Entry rode tekst-kleur geven bij een foutieve input
        }
    }
}
