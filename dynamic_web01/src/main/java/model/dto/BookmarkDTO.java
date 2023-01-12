package model.dto;

public class BookmarkDTO {
    // mapper에서의 순서와 상관없이 작성하면 된다.
    private String name;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookmarkDTO{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
