package algo.trading.common.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO representing user for start strategy. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyUser {
  @NotBlank(message = "Portfolio can not be blank")
  private String portfolio;

  @NotBlank(message = "Refresh token can not be blank")
  private String refreshToken;

  @NotBlank(message = "Login can not be blank")
  private String login;
}
