package algo.trading.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
  @NotBlank(message = "Symbol can not be blank")
  private String symbol;

  @NotNull(message = "Exchange can non be null")
  private Exchange exchange;

  private String shortname;
  private Currency currency;
  private BigDecimal pointPrice;
  private BigDecimal minStep;
}
