package services;

import com.elenakuropatkina.models.PictureData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import java.util.Optional;

@ComponentScan
public interface PictureService {

    Optional<String> getPictureContentTypeById(long id);

    Optional<byte[]> getPictureDataById(long id);

    PictureData createPictureData(byte[] picture);
}