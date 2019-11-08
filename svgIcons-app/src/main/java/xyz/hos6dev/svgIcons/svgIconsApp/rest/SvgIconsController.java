package xyz.hos6dev.svgIcons.svgIconsApp.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections4.MultiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hos6dev.svgIcons.svgIconsApp.logic.FilesResolver;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@Api(tags = {"svgIcons API"})
public class SvgIconsController {
    private FilesResolver filesResolver;

    @Autowired
    public SvgIconsController(FilesResolver filesResolver) {
        this.filesResolver = filesResolver;
    }

    @ApiOperation(value = "Retrieve a list of all files to display")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all files"),
            @ApiResponse(code = 401, message = "You are not authorized to view this resource"),
            @ApiResponse(code = 403, message = "Access to this resource is forbidden")
    })
    @GetMapping("/icons")
    public ResponseEntity<MultiMap<String,Iterable<String>>> getNews() {
        try {
            return ResponseEntity.ok(filesResolver.listFiles());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
