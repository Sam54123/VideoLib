package com.igrium.videolib.api;

import com.igrium.videolib.api.playback.CodecInterface;
import com.igrium.videolib.api.playback.ControlsInterface;
import com.igrium.videolib.api.playback.MediaInterface;
import com.igrium.videolib.api.playback.VideoEvents;

import net.minecraft.util.Identifier;

/**
 * Loads and plays a video.
 */
public interface VideoPlayer extends AutoCloseable {

    /**
     * Get the identifier of this video player.
     * @return Video player ID.
     */
    public Identifier getId();

    /**
     * Get the texture that this video player will write to.
     * @return Texture ID.
     */
    public Identifier getTexture();

    public MediaInterface getMediaInterface();
    public ControlsInterface getControlsInterface();
    public CodecInterface getCodecInterface();
    public VideoEvents getEvents();

    /**
     * Get a video handle factory that is compatible with this video player.
     * Shortcut for <code>getMediaInterface().getVideoHandleFactory();</code>
     * 
     * @return The video handle factory.
     * @see MediaInterface#getVideoHandleFactory()
     */
    public default VideoHandleFactory getHandleFactory() {
        return getMediaInterface().getVideoHandleFactory();
    }

    /**
     * Generate a texture identifier from a video player identifier. This is just an
     * internal utility function. It's not guarenteed that any given video player
     * will use this scheme. Use {@link VideoPlayer#getTexture()} instead.
     * 
     * @param id Video player ID.
     * @return Texture ID.
     */
    public static Identifier getTextureId(Identifier id) {
        String namespace = id.getNamespace();
        String path = "videoplayers/"+id.getPath();
        return new Identifier(namespace, path);
    }
}
