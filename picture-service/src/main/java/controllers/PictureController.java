package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.PictureService;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/picture")
public class PictureController {

        private final PictureService pictureService;

        @Autowired
        public PictureController(PictureService pictureService) {
            this.pictureService = pictureService;
        }

        @GetMapping("/{pictureId}")
        public void downloadProductPicture(@PathVariable("pictureId") Long pictureId, HttpServletResponse resp) throws IOException {

            Optional<String> optional = pictureService.getPictureContentTypeById(pictureId);
            if (optional.isPresent()) {
                resp.setContentType(optional.get());
                resp.getOutputStream().write(pictureService.getPictureDataById(pictureId).get());
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }


