
package com.dhakanewsclub.bookfinder.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containsEpubBubbles",
    "containsImageBubbles"
})
public class PanelizationSummary {

    @JsonProperty("containsEpubBubbles")
    private Boolean containsEpubBubbles;
    @JsonProperty("containsImageBubbles")
    private Boolean containsImageBubbles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("containsEpubBubbles")
    public Boolean getContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    @JsonProperty("containsEpubBubbles")
    public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    @JsonProperty("containsImageBubbles")
    public Boolean getContainsImageBubbles() {
        return containsImageBubbles;
    }

    @JsonProperty("containsImageBubbles")
    public void setContainsImageBubbles(Boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
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
