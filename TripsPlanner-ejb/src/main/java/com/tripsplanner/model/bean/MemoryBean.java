package com.tripsplanner.model.bean;

import javax.ejb.Stateless;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tripsplanner.model.entity.Memory;
import com.tripsplanner.model.entity.User;
import com.tripsplanner.model.facade.MemoryFacadeLocal;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.Part;



/**
 * Authors: Giovanni Bonetta, Riccardo Renzulli, Gabriele Sartor<br>
 * Università degli Studi di Torino<br>
 * Department of Computer Science<br>
 * Sviluppo Software per Componenti e Servizi Web<br>
 * Date: May 2018<br><br>
 * <p/>
 * giovanni.bonetta@edu.unito.it<br>
 * riccardo.renzulli@edu.unito.it<br>
 * gabriele.sartor@edu.unito.it<br><br>
 */

@Stateless
public class MemoryBean implements MemoryBeanLocal {

    @EJB
    private MemoryFacadeLocal memoryFacade;
    
    @EJB
    private ApiKeysBean apiKeysBean;
    private String amazon_access_key = apiKeysBean.keys.get("amazon_access_key");
    private String amazon_secret_key = apiKeysBean.keys.get("amazon_secret_key");

    @Override
    public Memory uploadMemory(String description, Part filePart, InputStream image, User user) throws ParseException {
        
        String clientRegion = "eu-west-3";
        String bucketName = "tripsplanner-bucket";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Date date = new Date();
        String timestamp = dateFormat.format(date);
        Date parsed = dateFormat.parse(timestamp);
        
        Memory memory = new Memory();
        memory.setText(description);
        memory.setDate(new java.sql.Date(parsed.getTime()));
        memory.setOwner(user);
                
        try {
            if (image.available() != 0) {
                BasicAWSCredentials awsCreds = new BasicAWSCredentials(amazon_access_key, amazon_secret_key);
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
                
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType("image/jpg");
                metadata.addUserMetadata("x-amz-meta-title", "someTitle");
                
                // Upload a file as a new object with ContentType and title specified.
                String imgKeyName = user.getGoogleID() + timestamp + "img";
                PutObjectRequest request = new PutObjectRequest(bucketName, imgKeyName, image, metadata);
                
                s3Client.putObject(request);
                memory.setImgURL(imgKeyName);
            }
        } catch (IOException ex) {
            Logger.getLogger(MemoryBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        memoryFacade.create(memory);
        return memory;
    }

    @Override
    public void removeMemory(Memory memory) {
        memoryFacade.remove(memory);
    }
}
