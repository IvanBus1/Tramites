/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncriptacionUtils {

    private static final String ALGORITHM = "AES";
    private static final String KEY = "MySuperSecretKey";

    public static String encriptarNombre(String nombre)  {
        try{
        
        SecretKeySpec keySpec = generateKeySpec(KEY);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(nombre.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
        }catch(Exception e){
            
            return null;
        }
    }

    public static String desencriptarNombre(String encryptedNombre) {
       
        try{
            
        
        SecretKeySpec keySpec = generateKeySpec(KEY);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedNombre));
        return new String(decrypted, StandardCharsets.UTF_8);
        }catch(Exception e){
           
            return null;
        }
    }
        
public static String encriptarApellidoPaterno(String apellidoPaterno) {
        try{
            return encriptarNombre(apellidoPaterno);
        }catch(Exception e){
            return null;
        }
        
    }

    public static String desencriptarApellidoPaterno(String encryptedApellidoPaterno)  {
        
        try{
        return desencriptarNombre(encryptedApellidoPaterno);
        }catch(Exception e){
            return null;
        }
    }

    public static String encriptarApellidoMaterno(String apellidoMaterno)  {
        try{
        
        return encriptarNombre(apellidoMaterno);
        
        }catch(Exception e){
            return null;
        }
    }

    public static String desencriptarApellidoMaterno(String encryptedApellidoMaterno)  {
        try{
        return desencriptarNombre(encryptedApellidoMaterno);
        }catch(Exception e){
            return null;
        }
    }

    private static SecretKeySpec generateKeySpec(String key)  {
        try{
       
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hashedKeyBytes = sha.digest(keyBytes);
        byte[] truncatedKeyBytes = new byte[16];
        System.arraycopy(hashedKeyBytes, 0, truncatedKeyBytes, 0, truncatedKeyBytes.length);
        return new SecretKeySpec(truncatedKeyBytes, ALGORITHM);
        }catch(Exception e){
            return null;
        }
    }
}