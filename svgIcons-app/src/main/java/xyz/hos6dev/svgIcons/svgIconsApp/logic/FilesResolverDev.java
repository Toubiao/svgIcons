package xyz.hos6dev.svgIcons.svgIconsApp.logic;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.stereotype.Component;
import xyz.hos6dev.svgIcons.svgIconsApp.dto.IconListDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FilesResolverDev {

    public List<IconListDTO> listFiles() {
        MultiMap<String, List<String>> mhm = new MultiValueMap<>();
        List<IconListDTO> iconsList = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get("D:/ICOONE/iconSVG"))) {
            // We want to find only regular files
            walk.filter(Files::isRegularFile)
                    .forEach(x -> mhm.put(correctPath(x.getParent().toString()), correctPath(x.toString())));

            mhm.entrySet().stream().forEach((key) -> {
                iconsList.add(new IconListDTO(key.getKey(), (List<String>) key.getValue()));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return iconsList;
    }

    private String correctPath(String path) {
        return path.replaceAll("[a-zA-Z]:\\\\(\\\\)?[\\w\\s_]+([iconSVG|_|\\\\|(|)|-]*|\\s)?", "").replace("\\", "/");
    }
}
