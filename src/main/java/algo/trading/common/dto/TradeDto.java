package algo.trading.common.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO represent a tg chat. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeDto {
  private String tradeId;
  private String orderId;
  private BigDecimal price;
  private BigDecimal commission;
}
