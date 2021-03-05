namespace Lottery.Domain
{
    public class DrawNumber
    {
        public Draw Draw { get; set; } //een drawnumber hoort telkens bij één Draw
        public int DrawId { get; set; }
        public int Number { get; set; }
        public int? Position { get; set; }
    }
}