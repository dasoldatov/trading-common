package algo.trading.common.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object representing an error. Contains error message, code, and timestamp of
 * occurrence.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
  private String message; // The error message
  private int code; // The error code
  private LocalDateTime timestamp; // The timestamp when the error occurred
}
