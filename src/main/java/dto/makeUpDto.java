package dto;

import lombok.Getter;

import java.util.Date;
import java.util.List;

//@Getter
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

        public Integer getId() {
                return id;
        }

        public String getBrand() {
                return brand;
        }

        public String getName() {
                return name;
        }

        public String getPrice() {
                return price;
        }

        public String getPrice_sign() {
                return price_sign;
        }

        public String getCurrency() {
                return currency;
        }

        public String getImage_link() {
                return image_link;
        }

        public String getProduct_link() {
                return product_link;
        }

        public String getWebsite_link() {
                return website_link;
        }

        public String getDescription() {
                return description;
        }

        public Object getRating() {
                return rating;
        }

        public String getCategory() {
                return category;
        }

        public String getProduct_type() {
                return product_type;
        }

        public List<String> getTag_list() {
                return tag_list;
        }

        public Date getCreated_at() {
                return created_at;
        }

        public Date getUpdated_at() {
                return updated_at;
        }

        public String getProduct_api_url() {
                return product_api_url;
        }

        public String getApi_featured_image() {
                return api_featured_image;
        }

        public List<productColorDto> getProduct_colours() {
                return product_colours;
        }
        public class productColorDto {
                public String hex_value;
                public String colour_name;
        }
}

