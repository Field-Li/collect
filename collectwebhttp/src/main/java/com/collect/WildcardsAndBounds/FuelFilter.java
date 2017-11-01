package com.collect.WildcardsAndBounds;

/**
 * Created by lifana on 2017/7/17.
 */
class Filter extends Part {}

class FuelFilter extends Filter {
    public static class Factory implements com.collect.WildcardsAndBounds.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements com.collect.WildcardsAndBounds.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements com.collect.WildcardsAndBounds.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
