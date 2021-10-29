package dto;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class makeUpDto {
        private Integer id;
        private String brand;
        private String name;
        private String price;
        private String price_sign;
        private String currency;
        private String image_link;
        private String product_link;
        private String website_link;
        private String description;
        private Object rating;
        private String category;
        private String product_type;
        private List<String> tag_list;
        private Date created_at;
        private Date updated_at;
        private String product_api_url;
        private String api_featured_image;
        private List<productColorDto> product_colours;
    }

