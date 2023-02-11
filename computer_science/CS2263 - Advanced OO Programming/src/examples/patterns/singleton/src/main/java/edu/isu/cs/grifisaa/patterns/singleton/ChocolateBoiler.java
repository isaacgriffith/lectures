public class ChocolateBoiler {
  private boolean empty;
  private boolean boiled;

  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }

  public static ChocolateBoiler getInstance() {
    return BoilerHelper.INSTANCE;
  }

  private static class BoilerHelper {
    public static final ChocolateBoiler INSTANCE = new ChocolateBoiler();
  }

  public void fill() {
    if (isEmpty()) {
      empty = false;
      boiled = false;
    }
  }

  public void drain() {
    if (!isEmpty() && isBoiled())
      empty = true;
  }

  public void boil() {
    if (!isEmpty() && !isBoiled()) {
      boiled = true;
    }
  }

  public boolean isEmpty() { return empty; }

  public boolean isBoiled() { return boiled; }
}
