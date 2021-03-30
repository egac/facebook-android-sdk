/*
 * Copyright (c) 2014-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to use,
 * copy, modify, and distribute this software in source code or binary form for use
 * in connection with the web services and APIs provided by Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use of
 * this software is subject to the Facebook Developer Principles and Policies
 * [http://developers.facebook.com/policy/]. This copyright notice shall be
 * included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.facebook.appevents.iap;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.concurrent.atomic.AtomicBoolean;

@AutoHandleExceptions
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public final class InAppPurchaseManager {

  private static final AtomicBoolean lib2enabled = new AtomicBoolean(false);
  private static final AtomicBoolean enabled = new AtomicBoolean(false);

  public static void enableAutoLogging() {
    enabled.set(true);
  }

  public static void enableLoggingLib2() {
    lib2enabled.set(true);
  }

  public static void startTracking() {
    if (enabled.get()) {
      if (lib2enabled.get() && usingBillingLib2Plus()) {
        // TODO: T84357984 Add logic to trigger IAP for billing library 2+
      } else {
        InAppPurchaseActivityLifecycleTracker.startIapLogging();
      }
    }
  }

  private static boolean usingBillingLib2Plus() {
    // TODO: T84357984 Add logic to check whether app using billing library 2+
    return false;
  }
}
