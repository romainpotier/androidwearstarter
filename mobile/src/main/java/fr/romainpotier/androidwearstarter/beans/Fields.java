package fr.romainpotier.androidwearstarter.beans;

import java.util.List;

public class Fields {

    private long arrondissement;
    private String nom;
    private String adresse;
    private List<Double> geo_latitude;
    private long prix_comptoir;
    private long prix_salle;
    private long prix_terasse;

    public long getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(final long arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    public List<Double> getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(final List<Double> geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public long getPrix_comptoir() {
        return prix_comptoir;
    }

    public void setPrix_comptoir(final long prix_comptoir) {
        this.prix_comptoir = prix_comptoir;
    }

    public long getPrix_salle() {
        return prix_salle;
    }

    public void setPrix_salle(final long prix_salle) {
        this.prix_salle = prix_salle;
    }

    public long getPrix_terasse() {
        return prix_terasse;
    }

    public void setPrix_terasse(final long prix_terasse) {
        this.prix_terasse = prix_terasse;
    }

    @Override
    public String toString() {
        return "Fields [arrondissement=" + arrondissement + ", nom=" + nom + ", adresse=" + adresse + ", geo_latitude=" + geo_latitude
                + ", prix_comptoir=" + prix_comptoir + ", prix_salle=" + prix_salle + ", prix_terasse=" + prix_terasse + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result + (int) (arrondissement ^ (arrondissement >>> 32));
        result = prime * result + ((geo_latitude == null) ? 0 : geo_latitude.hashCode());
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + (int) (prix_comptoir ^ (prix_comptoir >>> 32));
        result = prime * result + (int) (prix_salle ^ (prix_salle >>> 32));
        result = prime * result + (int) (prix_terasse ^ (prix_terasse >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Fields other = (Fields) obj;
        if (adresse == null) {
            if (other.adresse != null) {
                return false;
            }
        } else if (!adresse.equals(other.adresse)) {
            return false;
        }
        if (arrondissement != other.arrondissement) {
            return false;
        }
        if (geo_latitude == null) {
            if (other.geo_latitude != null) {
                return false;
            }
        } else if (!geo_latitude.equals(other.geo_latitude)) {
            return false;
        }
        if (nom == null) {
            if (other.nom != null) {
                return false;
            }
        } else if (!nom.equals(other.nom)) {
            return false;
        }
        if (prix_comptoir != other.prix_comptoir) {
            return false;
        }
        if (prix_salle != other.prix_salle) {
            return false;
        }
        if (prix_terasse != other.prix_terasse) {
            return false;
        }
        return true;
    }

}
