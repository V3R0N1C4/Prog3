package common.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * Rappresenta un'email con mittente, destinatari, oggetto, corpo e timestamp.
 */
public class Email implements Serializable {
    private static final long serialVersionUID = 1L; // Versione per la serializzazione

    private String id;                  // Identificativo univoco dell'email
    private String sender;              // Mittente dell'email
    private List<String> recipients;    // Lista dei destinatari
    private String subject;             // Oggetto dell'email
    private String body;                // Corpo del messaggio
    private LocalDateTime timestamp;    // Data e ora di creazione

    /**
     * Costruttore che inizializza i campi principali e genera un id e timestamp.
     * @param sender mittente dell'email
     * @param recipients lista dei destinatari
     * @param subject oggetto dell'email
     * @param body corpo del messaggio
     */
    public Email(String sender, List<String> recipients, String subject, String body) {
        this.id = UUID.randomUUID().toString(); // Genera un id univoco
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.timestamp = LocalDateTime.now(); // Imposta il timestamp corrente
    }

    // Getter e setter per tutti i campi

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getSender() { return sender; }

    public void setSender(String sender) { this.sender = sender; }

    public List<String> getRecipients() { return recipients; }

    public void setRecipients(List<String> recipients) { this.recipients = recipients; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public LocalDateTime getTimestamp() { return timestamp; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    /**
     * Restituisce il timestamp formattato come stringa leggibile.
     * @return data e ora in formato "dd/MM/yyyy HH:mm"
     */
    public String getFormattedTimestamp() {
        return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    /**
     * Rappresentazione testuale dell'email.
     * @return stringa con timestamp, mittente e oggetto
     */
    @Override
    public String toString() {
        return String.format("[%s] %s - %s", getFormattedTimestamp(), sender, subject);
    }
}