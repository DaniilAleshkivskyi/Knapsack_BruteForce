package Models;

public record ItemModel(int weight,
                        int value) {

    @Override
    public String toString() {
        return "Item(" + "weight=" + weight +", value=" + value + ')';
    }
}
