package backend.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import backend.app.model.Ishod;
import backend.app.model.LicniPodaci;
import backend.app.repository.FileRepository;

@Service
public class FileService {
	
	private String defaultProfilePicturePath = "src/main/resources/images/profile_images/default.png";
	
	@Autowired
	private FileRepository fileRepo; 

	public void saveProfileImage(MultipartFile file, String fileName, LicniPodaci lPodaci) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg"))) {
			File convertFile = new File("src/main/resources/images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			lPodaci.setPutanjaProfilneSlike("images/profile_images/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
		}
		else {
			InputStream initialStream = new FileInputStream(new File(defaultProfilePicturePath));
		    byte[] buffer = new byte[initialStream.available()];
		    initialStream.read(buffer);
		    File targetFile = new File("src/main/resources/images/profile_images/" + fileName + defaultProfilePicturePath.substring(defaultProfilePicturePath.lastIndexOf(".")));
		    targetFile.createNewFile();
		    OutputStream outStream = new FileOutputStream(targetFile);
		    outStream.write(buffer);
		    initialStream.close();
		    outStream.close();
		    lPodaci.setPutanjaProfilneSlike("images/profile_images/" + fileName + defaultProfilePicturePath.substring(defaultProfilePicturePath.lastIndexOf(".")));
		}
	}
	
	public void saveIshodIcon(MultipartFile file, String fileName, Ishod iPodaci) throws IOException {
	    Tika tika = new Tika();
	    String mimeType = tika.detect(file.getBytes());
		if(file != null && (mimeType.equals("image/png") || mimeType.equals("image/jpeg"))) {
			File convertFile = new File("src/main/resources/images/topic_icons/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
			iPodaci.setPutanjaDoIkonice("images/topic_icons/" + fileName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));
		}
	}
	
	public Iterable<Optional<backend.app.model.File>> getFileByPredmet(Long id) {
        return fileRepo.getAllByPredmet(id);
    }
	
}
