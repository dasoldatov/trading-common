package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO represent an instrument. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentDto {
  private String symbol;
  private String shortname;
  private Exchange exchange;
  private Currency currency;
  private BigDecimal pointPrice;
  private BigDecimal minStep;
}
