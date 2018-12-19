package org.chobit.wp.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MediaItem {

    @JsonProperty("attachment_id")
    private String attachmentId;

    @JsonProperty("date_created_gmt")
    private Date dateCreatedGmt;

    private int parent;

    private String link;

    private String title;

    private String caption;

    private String description;

    private MediaItemMetadata metadata;

    private String thumbnail;

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Date getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDateCreatedGmt(Date dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MediaItemMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(MediaItemMetadata metadata) {
        this.metadata = metadata;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public static class MediaItemMetadata {

        private int width;

        private int height;

        private String file;

        private MediaItemSizes sizes;

        @JsonProperty("image_meta")
        private PostThumbnailImageMeta imageMeta;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public MediaItemSizes getSizes() {
            return sizes;
        }

        public void setSizes(MediaItemSizes sizes) {
            this.sizes = sizes;
        }

        public PostThumbnailImageMeta getImageMeta() {
            return imageMeta;
        }

        public void setImageMeta(PostThumbnailImageMeta imageMeta) {
            this.imageMeta = imageMeta;
        }
    }


    public static class MediaItemSizes {

        private MediaItemSize thumbnail;

        private MediaItemSize medium;

        private MediaItemSize large;

        @JsonProperty("post_thumbnail")
        private MediaItemSize postThumbnail;

        public MediaItemSize getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(MediaItemSize thumbnail) {
            this.thumbnail = thumbnail;
        }

        public MediaItemSize getMedium() {
            return medium;
        }

        public void setMedium(MediaItemSize medium) {
            this.medium = medium;
        }

        public MediaItemSize getLarge() {
            return large;
        }

        public void setLarge(MediaItemSize large) {
            this.large = large;
        }

        public MediaItemSize getPostThumbnail() {
            return postThumbnail;
        }

        public void setPostThumbnail(MediaItemSize postThumbnail) {
            this.postThumbnail = postThumbnail;
        }
    }

    public static class MediaItemSize {

        private String file;

        private String width;

        private String height;

        @JsonProperty("mime_type")
        private String mimeType;

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }
    }


    public class PostThumbnailImageMeta {

        private int aperture;

        private String credit;

        private String camera;

        private String caption;

        @JsonProperty("created_timestamp")
        private int createdTimestamp;

        private String copyright;

        @JsonProperty("focal_length")
        private int focalLength;

        private int iso;

        @JsonProperty("shutter_speed")
        private int shutterSpeed;

        private String title;

        public int getAperture() {
            return aperture;
        }

        public void setAperture(int aperture) {
            this.aperture = aperture;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getCamera() {
            return camera;
        }

        public void setCamera(String camera) {
            this.camera = camera;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public int getCreatedTimestamp() {
            return createdTimestamp;
        }

        public void setCreatedTimestamp(int createdTimestamp) {
            this.createdTimestamp = createdTimestamp;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public int getFocalLength() {
            return focalLength;
        }

        public void setFocalLength(int focalLength) {
            this.focalLength = focalLength;
        }

        public int getIso() {
            return iso;
        }

        public void setIso(int iso) {
            this.iso = iso;
        }

        public int getShutterSpeed() {
            return shutterSpeed;
        }

        public void setShutterSpeed(int shutterSpeed) {
            this.shutterSpeed = shutterSpeed;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}




