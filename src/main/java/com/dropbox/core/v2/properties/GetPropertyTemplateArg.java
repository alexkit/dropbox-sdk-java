/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=GetPropertyTemplateArg.Serializer.class)
@JsonDeserialize(using=GetPropertyTemplateArg.Deserializer.class)
public class GetPropertyTemplateArg {
    // struct GetPropertyTemplateArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String templateId;

    /**
     *
     * @param templateId  An identifier for property template added by route
     *     properties/template/add. Must have length of at least 1, match
     *     pattern "{@code (/|ptid:).*}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetPropertyTemplateArg(String templateId) {
        if (templateId == null) {
            throw new IllegalArgumentException("Required value for 'templateId' is null");
        }
        if (templateId.length() < 1) {
            throw new IllegalArgumentException("String 'templateId' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("(/|ptid:).*", templateId)) {
            throw new IllegalArgumentException("String 'templateId' does not match pattern");
        }
        this.templateId = templateId;
    }

    /**
     * An identifier for property template added by route
     * properties/template/add.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTemplateId() {
        return templateId;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            templateId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            GetPropertyTemplateArg other = (GetPropertyTemplateArg) obj;
            return (this.templateId == other.templateId) || (this.templateId.equals(other.templateId));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<GetPropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(GetPropertyTemplateArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(GetPropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<GetPropertyTemplateArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(GetPropertyTemplateArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("template_id", value.templateId);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<GetPropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(GetPropertyTemplateArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(GetPropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<GetPropertyTemplateArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public GetPropertyTemplateArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String templateId = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("template_id".equals(_field)) {
                    templateId = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (templateId == null) {
                throw new JsonParseException(_p, "Required field \"template_id\" is missing.");
            }

            return new GetPropertyTemplateArg(templateId);
        }
    }
}
