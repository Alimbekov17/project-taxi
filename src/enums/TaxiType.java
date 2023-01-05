package enums;

import java.math.BigDecimal;

public enum TaxiType {
    STANDARD(new BigDecimal(10), new BigDecimal(60)),
    COMFORT(new BigDecimal(12), new BigDecimal(70)),
    BUSINESS(new BigDecimal(14), new BigDecimal(90));

    private final BigDecimal pricePerKm;
    private final BigDecimal priceForLanding;

    TaxiType(BigDecimal pricePerKm, BigDecimal priceForLanding) {
        this.pricePerKm = pricePerKm;
        this.priceForLanding = priceForLanding;
    }

    @Override
    public String toString() {
        return  "\nPrice per km     : " + pricePerKm + " som" +
                "\nPrice per landing: " + priceForLanding + " som";
    }
}
