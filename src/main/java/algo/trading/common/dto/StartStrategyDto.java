package algo.trading.common.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO for start strategy. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StartStrategyDto {
  @NotNull(message = "ID can not be null")
  @Positive(message = "ID can not be less than one")
  private Long strategyId;

  @NotNull(message = "Strategy name must not be null")
  private StrategyName strategyName;

  @Valid
  @NotNull(message = "Instrument can not be null")
  private InstrumentDto instrument;

  @NotNull(message = "Timeframe name must not be null")
  private Timeframe timeframe;

  @NotNull(message = "Lot quantity can not be null")
  @Positive(message = "Lot quantity can not be less than one")
  private Integer lotQuantity;

  @NotNull(message = "Stop loss coefficient can not be null")
  @Positive(message = "Stop loss coefficient can not be less or equal zero")
  private BigDecimal stopLossCoefficient;

  @NotNull(message = "Take Profit coefficient can not be null")
  @Positive(message = "Stop loss coefficient can not be less or equal zero")
  private BigDecimal takeProfitCoefficient;

  @Valid
  @NotNull(message = "User can not be null")
  private StrategyUser user;

  @NotNull private StrategyState state;

  private MarketOrder marketOrder;
}
