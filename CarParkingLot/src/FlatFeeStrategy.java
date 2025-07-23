import java.time.LocalDateTime;

public class FlatFeeStrategy implements  FeeStrategy{
    double flatFee;

    public FlatFeeStrategy(double flatFee) {
        this.flatFee = flatFee;
    }

    @Override
    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        return flatFee;
    }
}
