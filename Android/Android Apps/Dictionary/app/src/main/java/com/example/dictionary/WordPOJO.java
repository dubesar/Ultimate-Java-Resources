package com.example.dictionary;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "word",
        "phonetics",
        "meanings"
})
public class WordPOJO {

    @JsonProperty("word")
    private String word;
    @JsonProperty("phonetics")
    private List<Phonetic> phonetics = null;
    @JsonProperty("meanings")
    private List<Meaning> meanings = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("word")
    public String getWord() {
        return word;
    }

    @JsonProperty("word")
    public void setWord(String word) {
        this.word = word;
    }

    @JsonProperty("phonetics")
    public List<Phonetic> getPhonetics() {
        return phonetics;
    }

    @JsonProperty("phonetics")
    public void setPhonetics(List<Phonetic> phonetics) {
        this.phonetics = phonetics;
    }

    @JsonProperty("meanings")
    public List<Meaning> getMeanings() {
        return meanings;
    }

    @JsonProperty("meanings")
    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text",
        "audio"
})
 class Phonetic {

    @JsonProperty("text")
    private String text;
    @JsonProperty("audio")
    private String audio;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("audio")
    public String getAudio() {
        return audio;
    }

    @JsonProperty("audio")
    public void setAudio(String audio) {
        this.audio = audio;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "partOfSpeech",
        "definitions"
})
 class Meaning {

    @JsonProperty("partOfSpeech")
    private String partOfSpeech;
    @JsonProperty("definitions")
    private List<Definition> definitions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("partOfSpeech")
    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    @JsonProperty("partOfSpeech")
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @JsonProperty("definitions")
    public List<Definition> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "definition",
        "example",
        "synonyms"
})
 class Definition {

    @JsonProperty("definition")
    private String definition;
    @JsonProperty("example")
    private String example;
    @JsonProperty("synonyms")
    private List<String> synonyms = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("definition")
    public String getDefinition() {
        return definition;
    }

    @JsonProperty("definition")
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @JsonProperty("example")
    public String getExample() {
        return example;
    }

    @JsonProperty("example")
    public void setExample(String example) {
        this.example = example;
    }

    @JsonProperty("synonyms")
    public List<String> getSynonyms() {
        return synonyms;
    }

    @JsonProperty("synonyms")
    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}