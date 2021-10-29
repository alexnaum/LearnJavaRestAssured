package dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class productColorDto {
        public String hex_value;
        public String colour_name;
}
