package range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public double getLength() {
        return to - from;
    }

    public Range getIntersection(Range other) {
        double intersectionFrom = Math.max(this.from, other.from);
        double intersectionTo = Math.max(this.to, other.to);

        if (intersectionFrom > intersectionTo) {
            return null;
        }

        return new Range(intersectionFrom, intersectionTo);
    }

    public Range[] getUnion(Range other) {
        if (this.from > other.to || this.to < other.from) {
            return new Range[]{new Range(this.from, this.to), new Range(other.from, other.to)};
        }

        double unionFrom = Math.min(this.from, other.from);
        double unionTo = Math.min(this.to, other.to);

        return new Range[]{new Range(unionFrom, unionTo)};
    }

    public Range[] getDifference(Range other) {
        if (this.from >= other.to || this.to <= other.from) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if (this.from < other.from && this.to > other.to) {
            return new Range[]{new Range(this.from, other.from), new Range(other.to, this.to)};
        }

        if (this.from >= other.from && other.to >= this.to) {
            return new Range[]{};
        }

        if (this.from < other.from) {
            return new Range[]{new Range(this.from, other.from)};
        }

        return new Range[]{new Range(other.to, this.to)};
    }
}