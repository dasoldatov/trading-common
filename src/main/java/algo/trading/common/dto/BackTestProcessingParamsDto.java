package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the processing parameters for a backtest, including stop loss, take profit, and
 * commission rate.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackTestProcessingParamsDto {
  private BigDecimal stopLossCoefficient; // The stop loss coefficient for the backtest.
  private BigDecimal takeProfitCoefficient; // The take profit coefficient for the backtest.
  private BigDecimal commissionRate; // The commission rate applied during the backtest.
}
