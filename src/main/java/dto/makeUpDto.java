package dto;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class makeUpDto{
        public int id;
        public String brand;
        public String name;
        public String price;
        public Object price_sign;
        public Object currency;
        public String image_link;
        public String product_link;
        public String website_link;
        public String description;
        public double rating;
        public String category;
        public String product_type;
        public List<String> tag_list;
        public Date created_at;
        public Date updated_at;
        public String product_api_url;
        public String api_featured_image;
        public List<productColor> product_colors;
        public class productColor{
                public String hex_value;
                public String colour_name;
        }
}
