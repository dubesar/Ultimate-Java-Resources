package com.zukron.newsapp.model;

import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<NewsResponseArticles> articles;

    public int getTotalResults() {
        return this.totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsResponseArticles> getArticles() {
        return this.articles;
    }

    public void setArticles(List<NewsResponseArticles> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class NewsResponseArticles {
        private NewsResponseArticlesSource source;
        private String publishedAt;
        private String author;
        private String urlToImage;
        private String description;
        private String title;
        private String url;
        private String content;

        public String getPublishedAt() {
            return this.publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUrlToImage() {
            return this.urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public NewsResponseArticlesSource getSource() {
            return this.source;
        }

        public void setSource(NewsResponseArticlesSource source) {
            this.source = source;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public static class NewsResponseArticlesSource {
            private String name;
            private String id;

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return this.id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
