package fr.romainpotier.androidwearstarter.beans;

import java.util.List;

public class Parameters {

    private long rows;
    private String format;
    private List<String> dataset;

    public long getRows() {
        return rows;
    }

    public void setRows(final long rows) {
        this.rows = rows;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }

    public List<String> getDataset() {
        return dataset;
    }

    public void setDataset(final List<String> dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "Parameters [rows=" + rows + ", format=" + format + ", dataset=" + dataset + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataset == null) ? 0 : dataset.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + (int) (rows ^ (rows >>> 32));
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
        Parameters other = (Parameters) obj;
        if (dataset == null) {
            if (other.dataset != null) {
                return false;
            }
        } else if (!dataset.equals(other.dataset)) {
            return false;
        }
        if (format == null) {
            if (other.format != null) {
                return false;
            }
        } else if (!format.equals(other.format)) {
            return false;
        }
        if (rows != other.rows) {
            return false;
        }
        return true;
    }

}
