package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/** DTO represent an instrument. */
@Data
@Builder
public class InstrumentDto {
  private String symbol;
  private String shortname;
  private Exchange exchange;
  private Currency currency;
  private BigDecimal pointPrice;
  private BigDecimal minStep;
}
