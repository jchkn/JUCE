/*
  ==============================================================================

   This file is part of the JUCE library.
   Copyright (c) 2017 - ROLI Ltd.

   JUCE is an open source library subject to commercial or open-source
   licensing.

   By using JUCE, you agree to the terms of both the JUCE 5 End-User License
   Agreement and JUCE 5 Privacy Policy (both updated and effective as of the
   27th April 2017).

   End User License Agreement: www.juce.com/juce-5-licence
   Privacy Policy: www.juce.com/juce-5-privacy-policy

   Or: You may also use this code under the terms of the GPL v3 (see
   www.gnu.org/licenses).

   JUCE IS PROVIDED "AS IS" WITHOUT ANY WARRANTY, AND ALL WARRANTIES, WHETHER
   EXPRESSED OR IMPLIED, INCLUDING MERCHANTABILITY AND FITNESS FOR PURPOSE, ARE
   DISCLAIMED.

  ==============================================================================
*/

package com.roli.juce;

import android.media.session.MediaSession;

import java.lang.String;

import android.os.Bundle;
import android.content.Intent;

import java.util.List;

//==============================================================================
public class MediaSessionCallback extends MediaSession.Callback
{
    private native void mediaSessionPause (long host);
    private native void mediaSessionPlay (long host);
    private native void mediaSessionPlayFromMediaId (long host, String mediaId, Bundle extras);
    private native void mediaSessionSeekTo (long host, long pos);
    private native void mediaSessionStop (long host);

    MediaSessionCallback (long hostToUse)
    {
        host = hostToUse;
    }

    @Override
    public void onPause ()
    {
        mediaSessionPause (host);
    }

    @Override
    public void onPlay ()
    {
        mediaSessionPlay (host);
    }

    @Override
    public void onPlayFromMediaId (String mediaId, Bundle extras)
    {
        mediaSessionPlayFromMediaId (host, mediaId, extras);
    }

    @Override
    public void onSeekTo (long pos)
    {
        mediaSessionSeekTo (host, pos);
    }

    @Override
    public void onStop ()
    {
        mediaSessionStop (host);
    }

    @Override
    public void onFastForward () {}

    @Override
    public boolean onMediaButtonEvent (Intent mediaButtonIntent)
    {
        return true;
    }

    @Override
    public void onRewind () {}

    @Override
    public void onSkipToNext () {}

    @Override
    public void onSkipToPrevious () {}

    @Override
    public void onSkipToQueueItem (long id) {}

    private long host;
}
