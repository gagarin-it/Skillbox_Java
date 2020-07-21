public class EnglishText {

  public static void main(String[] args) {
    String text = "Americans are always on the move. They drive their cars every day. Every other day or month they fly to another state in America or fly overseas. And no matter whether Americans go international or stay at home, which is flying to another corner of the US, their top priority will be looking good after a flight. \"Everything about an airplane\", says Amber Valetta, a model and an actress, is stale: the air, the water, and your skin and hair after you land. But even if you feel like crashing, you don’t have to look like it. Instead, Amber gives the following flying tips: Prepare the hair. It’s best to travel with clean, dry hair. Mist it with leave-in conditioner in the morning, and then coil it into a bun to keep it off your face during the flight, leave loose, smooth waves afterward. Dress the part. Wear something in a fabric that is loose and won’t wrinkle - definitely no linen or silk. Watch the cart. Drink eight ounces of water for every hour you are in the air. Never drink alcohol and have a Coke very rarely.";
    String[] textMassive = text.replaceAll("[!-@]", " ").split("\\s+");
    for (int i = 0; i < textMassive.length; i++) {
      System.out.println(textMassive[i]);
    }
  }
}
