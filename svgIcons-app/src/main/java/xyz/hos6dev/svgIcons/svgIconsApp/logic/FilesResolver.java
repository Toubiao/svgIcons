package xyz.hos6dev.svgIcons.svgIconsApp.logic;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.stereotype.Component;
import xyz.hos6dev.svgIcons.svgIconsApp.dto.IconListDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FilesResolver {

    public MultiMap<String,Iterable<String>> listFiles(){
        MultiMap<String,Iterable<String>> mhm = new MultiValueMap<>();
        try (Stream<Path> walk = Files.walk(Paths.get("/var/www/iconSVG"))) {
             walk.filter(Files::isRegularFile)
                    .forEach(x -> mhm.put(correctPath(x.getParent().toString()),correctPath(x.toString())));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mhm;
    }
    private String correctPath(String path){
        return path.replaceAll("^(\\/[^\\/ ]*|)+(\\/iconSVG\\/)","").replace("\\","/");
    }
}
