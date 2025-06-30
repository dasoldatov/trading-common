package algo.trading.common.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO represent a tg chat. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
  @NotBlank(message = "Chat ID can not be blank")
  private String chatId;
}
