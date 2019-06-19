package com.fudan.entity;

import java.io.Serializable;

/**
 * option
 * @author 
 */
public class Option implements Serializable {
    private Integer id;

    private String text;

    private Integer contentId;

    private Boolean isCorrect;

    private Integer optionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Option other = (Option) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getText() == null ? other.getText() == null : this.getText().equals(other.getText()))
            && (this.getContentId() == null ? other.getContentId() == null : this.getContentId().equals(other.getContentId()))
            && (this.getIsCorrect() == null ? other.getIsCorrect() == null : this.getIsCorrect().equals(other.getIsCorrect()))
            && (this.getOptionId() == null ? other.getOptionId() == null : this.getOptionId().equals(other.getOptionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
        result = prime * result + ((getContentId() == null) ? 0 : getContentId().hashCode());
        result = prime * result + ((getIsCorrect() == null) ? 0 : getIsCorrect().hashCode());
        result = prime * result + ((getOptionId() == null) ? 0 : getOptionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", text=").append(text);
        sb.append(", contentId=").append(contentId);
        sb.append(", isCorrect=").append(isCorrect);
        sb.append(", optionId=").append(optionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}