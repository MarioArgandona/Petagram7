package marioargandona.com.petagram6.entidades;

/**
 * Created by Robert on 7/23/2016.
 */
public class Mascota {

    private int id;
    private String nombreMascota;
    private Integer foto;

    private String idInstagram;
    private String nombreCompleto;
    private String urlFoto;
    private Integer likes;
    private String mediaLink;
    private String mediaId;


    public Mascota(String nombreMascota , Integer foto , Integer likes)
    {
        this.nombreMascota = nombreMascota;
        this.foto = foto;
        this.likes = likes;
    }




    public Mascota(String idInstagram , String nombreCompleto , String urlFoto , Integer likes)
    {
        this.idInstagram = idInstagram;
        this.nombreCompleto = nombreCompleto;
        this.urlFoto = urlFoto;
        this.likes = likes;
    }


    public Mascota(String idInstagram , String nombreCompleto , String urlFoto , Integer likes , String mediaLink , String mediaId)
    {
        this.idInstagram = idInstagram;
        this.nombreCompleto = nombreCompleto;
        this.urlFoto = urlFoto;
        this.likes = likes;
        this.mediaLink = mediaLink;
        this.mediaId = mediaId;
    }


    public Mascota(String nombreMascota , Integer foto)
    {
        this.nombreMascota = nombreMascota;
        this.foto = foto;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public String getIdInstagram() {
        return idInstagram;
    }

    public void setIdInstagram(String idInstagram) {
        this.idInstagram = idInstagram;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreComleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
