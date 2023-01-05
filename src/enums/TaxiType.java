package enums;

import java.math.BigDecimal;

public enum TaxiType {
    STANDARD,
    COMFORT,
    BUSINESS;

    private BigDecimal pricePerKm;
    private BigDecimal priceForLanding;
}
