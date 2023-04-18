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
/**
 * Clase para la encriptacion
 * @author IVAN
 */
public class EncriptacionUtils {

    /**
     * Atributo de tipo String para el cifrado
     */
    private static final String ALGORITHM = "AES";

    /**
     * Atributo que es la llave del cifrado
     */
    private static final String KEY = "MySuperSecretKey";

    /**
     *
     * Método que encripta un nombre utilizando el algoritmo AES con la clave
     * especificada.
     *
     * @param nombre El nombre a encriptar.
     * @return El nombre encriptado como una cadena codificada en Base64.
     */
    public static String encriptarNombre(String nombre) {
        try {

            SecretKeySpec keySpec = generateKeySpec(KEY);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(nombre.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {

            return null;
        }
    }

    /**
     *
     * Método que desencripta un nombre previamente encriptado utilizando el
     * algoritmo AES con la clave especificada.
     *
     * @param encryptedNombre El nombre encriptado como una cadena codificada en
     * Base64.
     * @return El nombre desencriptado.
     */
    public static String desencriptarNombre(String encryptedNombre) {

        try {

            SecretKeySpec keySpec = generateKeySpec(KEY);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedNombre));
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {

            return null;
        }
    }

    /**
     *
     * Método que encripta un apellido paterno utilizando el método
     * encriptarNombre.
     *
     * @param apellidoPaterno El apellido paterno a encriptar.
     * @return El apellido paterno encriptado como una cadena codificada en
     * Base64.
     */
    public static String encriptarApellidoPaterno(String apellidoPaterno) {
        try {
            return encriptarNombre(apellidoPaterno);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     *
     * Método que desencripta un apellido paterno previamente encriptado
     * utilizando el método desencriptarNombre.
     *
     * @param encryptedApellidoPaterno El apellido paterno encriptado como una
     * cadena codificada en Base64.
     * @return El apellido paterno desencriptado.
     */
    public static String desencriptarApellidoPaterno(String encryptedApellidoPaterno) {

        try {
            return desencriptarNombre(encryptedApellidoPaterno);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * Método que encripta un apellido materno utilizando el método
     * encriptarNombre.
     *
     * @param apellidoMaterno El apellido materno a encriptar.
     * @return El apellido materno encriptado como una cadena codificada en
     * Base64.
     */
    public static String encriptarApellidoMaterno(String apellidoMaterno) {
        try {

            return encriptarNombre(apellidoMaterno);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Desencripta un apellido materno previamente encriptado utilizando el
     * algoritmo AES con una clave secreta.
     *
     * @param encryptedApellidoMaterno El apellido materno encriptado.
     * @return El apellido materno desencriptado, o null si ocurre una
     * excepción.
     */
    public static String desencriptarApellidoMaterno(String encryptedApellidoMaterno) {
        try {
            return desencriptarNombre(encryptedApellidoMaterno);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Genera una clave secreta de tipo {@link SecretKeySpec} utilizando el
     * algoritmo SHA-1 a partir de una cadena de texto.
     *
     * @param key La cadena de texto que se utilizará como clave.
     * @return La clave secreta generada, o null si ocurre una excepción.
     */
    private static SecretKeySpec generateKeySpec(String key) {
        try {

            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedKeyBytes = sha.digest(keyBytes);
            byte[] truncatedKeyBytes = new byte[16];
            System.arraycopy(hashedKeyBytes, 0, truncatedKeyBytes, 0, truncatedKeyBytes.length);
            return new SecretKeySpec(truncatedKeyBytes, ALGORITHM);
        } catch (Exception e) {
            return null;
        }
    }
}
