package minsu.restapi.spring;

public class FileDownloadException extends RuntimeException {
    public FileDownloadException(String message) {
        super(message);
    }

    public FileDownloadException(String message, Throwable cause) {
        super(message, cause);
    }
}