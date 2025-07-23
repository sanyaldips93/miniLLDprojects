import java.time.LocalDateTime;
import java.time.Duration;

public class HourlyFeeStrategy implements  FeeStrategy{
    double hourlyRate;

    public HourlyFeeStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        if (hours == 0) hours = 1;
        return hours * this.hourlyRate;
    }
}
