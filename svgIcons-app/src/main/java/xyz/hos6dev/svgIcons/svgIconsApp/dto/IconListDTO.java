package xyz.hos6dev.svgIcons.svgIconsApp.dto;

import java.util.List;

public class IconListDTO {
    private String title;
    private List<String> svgIcons;

    public IconListDTO(String title, List<String> svgIcons) {
        this.title = title;
        this.svgIcons = svgIcons;
    }

    public List<String> getSvgIcons() {
        return svgIcons;
    }

    public void setSvgIcons(List<String> svgIcons) {
        this.svgIcons = svgIcons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
