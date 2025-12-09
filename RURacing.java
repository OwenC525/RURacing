import java.util.ArrayList;
// Removed Scanner and InputMismatchException imports
import java.util.List;

/**
 * RU Racing: The Algorithmic Grand Prix of Rutgers University
 * =========================================================
 * 
 * In the bustling campus of Rutgers University, a legendary competition has
 * emerged from the
 * intersection of computer science and classic racing: The Algorithmic Grand
 * Prix. This race
 * showcases the practical application of algorithmic complexity through a
 * thrilling competition
 * that pushes the boundaries of teleportation technology.
 * 
 * THE LORE:
 * ---------
 * In the year 2062, a historic collaboration between Rutgers' Computer Science and Physics
 * departments led to a revolutionary breakthrough. Professor Sesh Venugopal from CS and 
 * Dr. Angela Merkel from Physics jointly published a paper on "Quantum-Computational Teleportation
 * Matrices" that shattered previous limitations in quantum mechanics.
 * 
 * Their combined expertise produced the ScarletTeleporter™, harnessing quantum entanglement
 * and computational topology to instantly move objects across space. The prototype, built in
 * the underground labs beneath the Physics Building on Busch Campus, caused quite a stir 
 * when a freshman accidentally teleported an entire batch of Friday the 13th dining hall 
 * meatloaf into President Holloway's office.
 * 
 * Despite this mishap, the ScarletTeleporter™ revolutionized transportation at Rutgers, 
 * allowing students to teleport between campuses in the blink of an eye. However, the 
 * Physics department quickly identified a fundamental constraint: the quantum particle 
 * accelerator powering the device had significant energy requirements tied to Heisenberg's
 * Uncertainty Principle. Different implementations had varying power requirements and 
 * capabilities based on their algorithmic approach to quantum field stabilization.
 * 
 * Seeing an educational opportunity, the departments collaborated to create the Algorithmic
 * Grand Prix - a race that would demonstrate not just teleportation technology, but the 
 * real-world impact of algorithmic efficiency on quantum physical systems.
 * 
 * THE RACERS:
 * -----------
 * 1. ScarletKnight (⚔): The traditional mascot of Rutgers, equipped with the
 * most basic
 * teleporter. This racer demonstrates O(N) linear time complexity, steadily
 * advancing one
 * step at a time without needing to charge. While consistent, this approach
 * lacks the
 * advantage of longer jumps.
 * 
 * 2. StarbucksTruck (🚚): Named after the popular coffee truck often found on
 * College Avenue,
 * this racer exemplifies O(N²) quadratic time complexity. The truck carries
 * enormous batteries
 * that take N turns to charge but only teleport one space at a time, making it
 * reliable but
 * inefficient for long races.
 * 
 * 3. LogNExpress (🚎): Named after the LX bus route that connects Livingston
 * and College Avenue,
 * this racer demonstrates O(log N) logarithmic time complexity. It can double
 * its teleportation
 * distance with each jump (1, 2, 4, 8...) without charging, allowing it to
 * cover ground
 * exponentially faster.
 * 
 * 4. NLogNExpress (🚌): Named after the most efficient sorting algorithms, this
 * racer combines
 * logarithmic jumps with linear charging time, demonstrating O(N log N)
 * complexity. It requires
 * N turns to charge between each jump, but its jump distance doubles each time.
 * 
 * THE RACE:
 * ---------
 * The race takes place on tracks that loop around Rutgers campuses. Each racer
 * must complete
 * exactly one lap, starting and finishing at the same point. Racers are ranked
 * based on:
 * 1. Fewest actions taken (fastest time)
 * 2. In case of a tie, greatest distance traveled
 * 
 * Each racer employs a different strategy based on algorithmic complexity
 * theories:
 * - O(N) linear: Move forward consistently one step per action
 * - O(N²) quadratic: Charge for N actions, then move one step
 * - O(log N) logarithmic: Double teleportation distance with each move action
 * - O(N log N): Charge for N actions, then double teleportation distance
 * 
 * Important rule: In each simulation step where a racer acts, it can perform only ONE action - either charge
 * its battery OR teleport. This constraint creates the different time complexity behaviors.
 * 
 * Will the slow-and-steady ScarletKnight prevail? Or will the logarithmic
 * efficiency of the
 * LogNExpress zoom to victory? The outcome depends on the length of the track
 * and the
 * implementation of each racing strategy.
 * 
 * Students must implement these strategies to understand how algorithmic
 * complexity affects
 * real-world performance!
 * 
 * @author elianddb
 */
public class RURacing {
    private List<Racer> racers;
    private Track track;

    /**
     * Constructs a new race simulation with a specified track.
     * This constructor initializes four racers, each employing a different
     * algorithmic strategy:
     * - ScarletKnight: O(N) linear time complexity
     * - StarbucksTruck: O(N²) quadratic time complexity
     * - LogNExpress: O(log N) logarithmic time complexity
     * - NLogNExpress: O(N log N) time complexity
     * 
     * Note that racers with charging requirements (StarbucksTruck and NLogNExpress)
     * are
     * initialized with a charge actions count equal to the track length, representing the
     * O(N)
     * component of their time complexity.
     * 
     * @param track The track on which the race will be simulated
     * @throws IllegalArgumentException if the track is null
     */
    public RURacing(Track track) {
        if (track == null) {
            throw new IllegalArgumentException("Track cannot be null.");
        }

        // Initialize each racer with the given track
        this.track = track;
        this.racers = List.of(
                new Racer("ScarletKnight", "⚔", track, 0),
                new Racer("StarbucksTruck", "🚚", track, track.getLength()),
                new Racer("LogNExpress", "🚎", track, 0),
                new Racer("NLogNExpress", "🚌", track, track.getLength()));
    }

    // -----------------------------------------------------
    // STUDENT METHODS - IMPLEMENT THESE METHODS
    // -----------------------------------------------------

    /**
     * O(N²) Strategy - Quadratic time complexity implementation.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * This strategy requires the racer to charge its battery for N actions between
     * each teleportation.
     * For a track of length N, the racer should:
     * - Teleport 1 step immediately on its first action (since battery starts full)
     * - Charge for N actions
     * - Teleport 1 step (total actions for this step: N+1)
     * - Charge for N more actions
     * - Teleport 1 step (total actions for this step: N+1)
     * ... and so on, resulting in O(N²) time complexity.
     * 
     * Note: Each time this racer acts, it can only perform ONE action - either charge or
     * teleport.
     * This racer must spend N actions charging before each teleport (after the first).
     *
     * @param racer The racer to which this strategy is applied
     */
    public static void applyStarbucksTruckAction(Racer racer) {
        if (racer == null || racer.hasFinishedRace()) {
            return;
        }

        int battery = racer.getBattery();
        int chargeTime = racer.getChargeTime();

        // If battery is full, teleport 1 step (if there is space left)
        if (battery == chargeTime) {
            int trackLength = racer.getTrack().getLength();
            int remaining = trackLength - racer.getDistance();

            if (remaining > 0) {
                // Move exactly 1 step (or remaining, just in case)
                int move = Math.min(1, remaining);
                racer.useScarletTeleporterTM(move);
            }
        } else {
            // Otherwise, spend this action charging
            racer.chargeBattery();
        }
    }

    /**
     * O(N log N) Strategy - N * logarithmic time complexity implementation.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * This strategy should combine charging time with exponentially increasing
     * teleport distances:
     * - Teleport 1 step immediately on its first action (since battery starts full)
     * - Charge for N actions
     * - Teleport 2 steps (total actions for this step: N+1)
     * - Charge for N more actions
     * - Teleport 4 steps (total actions for this step: N+1)
     * ... and so on, doubling the distance each time a teleport occurs.
     * 
     * Note: Each time this racer acts, it can only perform ONE action - either charge or
     * teleport.
     * This racer must spend N actions charging before each teleport (after the first) with
     * exponentially increasing distances.
     * 
     * @param racer The racer to which this strategy is applied
     */
    public static void applyNLogNExpressAction(Racer racer) {
        if (racer == null || racer.hasFinishedRace()) {
            return;
        }

        int battery = racer.getBattery();
        int chargeTime = racer.getChargeTime();

        // If battery is not yet full, charge this action
        if (battery < chargeTime) {
            racer.chargeBattery();
            return;
        }

        // Battery is full: perform a teleport whose distance is a power of 2
        int trackLength = racer.getTrack().getLength();
        int currentDistance = racer.getDistance();
        int remaining = trackLength - currentDistance;

        if (remaining <= 0) {
            return;
        }

        int jumpDistance;

        if (currentDistance <= 0) {
            // First jump should always be 1
            jumpDistance = 1;
        } else {
            // Distance after k full jumps is roughly 2^k - 1
            // So log2(currentDistance) ≈ k - 1  → next exponent is k
            double log2 = Math.log(currentDistance) / Math.log(2.0);
            int lastExponent = (int) log2;      // exponent of last completed power-of-2 jump
            int nextExponent = lastExponent + 1;
            jumpDistance = 1 << nextExponent;   // 2^(nextExponent)
        }

        // Do not go past the end of the track
        int move = Math.min(jumpDistance, remaining);

        // Always move at least 1 step if there is room
        if (move < 1 && remaining > 0) {
            move = 1;
        }

        racer.useScarletTeleporterTM(move);
    }
    

    /**
     * O(N) Strategy - Linear time complexity implementation.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * This strategy should make the racer take exactly N teleportation actions to
     * complete the track,
     * with no charging time. The racer should move at a constant speed of 1 step
     * per action,
     * resulting in O(N) time complexity.
     * 
     * Note: Each time this racer acts, it can only perform ONE action - teleport.
     * This racer doesn't need to charge, so it teleports every time it acts.
     *
     * @param racer The racer to which this strategy is applied
     */
    public static void applyScarletKnightAction(Racer racer) {
        if (racer == null || racer.hasFinishedRace()) {
            return;
        }

        int trackLength = racer.getTrack().getLength();
        int remaining = trackLength - racer.getDistance();

        if (remaining <= 0) {
            return;
        }

        // Move one step per action
        int move = Math.min(1, remaining);
        racer.useScarletTeleporterTM(move);
    }

    /**
     * O(log N) Strategy - Logarithmic time complexity implementation.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * This strategy should use exponentially increasing teleport distances to
     * complete the track,
     * with no charging time between teleports. The racer should move:
     * - 1 step on action 1
     * - 2 steps on action 2
     * - 4 steps on action 3
     * - 8 steps on action 4
     * ... and so on, doubling the distance with each teleport action.
     * 
     * Note: Each time this racer acts, it can only perform ONE action - teleport.
     * This racer doesn't need to charge, so it teleports every time it acts with
     * exponentially increasing distances.
     * 
     * @param racer The racer to which this strategy is applied
     */
    public static void applyLogNExpressAction(Racer racer) {
        if (racer == null || racer.hasFinishedRace()) {
            return;
        }

        int trackLength = racer.getTrack().getLength();
        int currentDistance = racer.getDistance();
        int remaining = trackLength - currentDistance;

        if (remaining <= 0) {
            return;
        }

        // Action count for this racer equals how many teleports they've done so far
        long actionsSoFar = racer.getActionsCount();
        // Distance this action: 1, 2, 4, 8, ... = 2^(actionsSoFar)
        // (first action has actionsSoFar == 0)
        int jumpDistance = 1 << (int) actionsSoFar;

        int move = Math.min(jumpDistance, remaining);

        // Make sure we still move at least one step if there is room
        if (move < 1 && remaining > 0) {
            move = 1;
        }

        racer.useScarletTeleporterTM(move);
    }

    /**
     * Applies the appropriate action strategy for a racer based on their name.
     * Made public so it can be called from the UI.
     * 
     * Each racer gets ONE action per simulation step - either charge their battery or
     * teleport.
     * This method selects and applies the correct strategy based on the racer type.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * @param racer the racer to apply the action strategy to
     */
    public void applyActionStrategy(Racer racer) {
        if (racer == null || racer.hasFinishedRace()) {
            return;
        }

        String name = racer.getName();

        if ("ScarletKnight".equals(name)) {
            applyScarletKnightAction(racer);
        } else if ("StarbucksTruck".equals(name)) {
            applyStarbucksTruckAction(racer);
        } else if ("LogNExpress".equals(name)) {
            applyLogNExpressAction(racer);
        } else if ("NLogNExpress".equals(name)) {
            applyNLogNExpressAction(racer);
        } else {
            // Unknown racer type – do nothing (or could throw an exception)
        }
    }

    /**
     * Static method to rank a list of racers using Insertion Sort (stable).
     * Racers are ranked first by who has traveled the FARTHEST distance,
     * and if there's a tie, then by who has used the FEWEST actions.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * @param racers List of racers to rank
     * @return Ranked list of racers (highest distance first, then lowest action count)
     */
    public static List<Racer> rankRacers(List<Racer> racers) {
                if (racers == null) {
            return null;
        }

        // Insertion sort (stable)
        for (int i = 1; i < racers.size(); i++) {
            Racer key = racers.get(i);
            int j = i - 1;

            while (j >= 0 && isHigherRank(key, racers.get(j))) {
                racers.set(j + 1, racers.get(j));
                j--;
            }
            racers.set(j + 1, key);
        }

        return racers;
    }

    /**
     * Returns true if a should be ranked higher (earlier) than b.
     */
    private static boolean isHigherRank(Racer a, Racer b) {
        // Primary: greater distance
        if (a.getDistance() > b.getDistance()) {
            return true;
        }
        if (a.getDistance() < b.getDistance()) {
            return false;
        }

        // Secondary: fewer actions
        if (a.getActionsCount() < b.getActionsCount()) {
            return true;
        }
        if (a.getActionsCount() > b.getActionsCount()) {
            return false;
        }

        // Completely tied – keep original order (stable sort)
        return false;
    }

    /**
     * Simulates a race with a specified maximum number of simulation steps (cutoff).
     * In each step, every racer that hasn't finished performs exactly ONE action based on their strategy
     * (either charging or teleporting). The simulation stops when all racers finish or
     * the cutoff number of steps is reached.
     * 
     * TODO: STUDENT - Implement this method
     * 
     * @param cutoff   Maximum number of simulation steps before ending the simulation
     * @return Ranked list of racers at the end of the simulation
     */
    public List<Racer> simulateRace(long cutoff) {
        if (cutoff < 0) {
            cutoff = 0;
        }

        long steps = 0;
        boolean allFinished = false;

        while (!allFinished && steps < cutoff) {
            allFinished = true; // assume finished until we find someone still racing

            for (Racer racer : racers) {
                if (!racer.hasFinishedRace()) {
                    allFinished = false;
                    applyActionStrategy(racer);  // exactly ONE action for this racer
                }
            }

            steps++;
        }

        // Rank racers at the end of the simulation
        return rankRacers();
    }

    // -----------------------------------------------------
    // PRE-WRITTEN METHODS - DO NOT MODIFY
    // -----------------------------------------------------

    /**
     * Ranks racers based on performance (fewest actions, then distance).
     * 
     * @return List of racers sorted by rank
     */
    public List<Racer> rankRacers() {
        return rankRacers(new ArrayList<>(racers));
    }

    /**
     * Simulates a race without a specified step limit.
     * This method is a convenience wrapper for the full simulateRace method that
     * uses
     * the maximum possible number of steps as the cutoff.
     */
    public List<Racer> simulateRace() {
        return simulateRace(Long.MAX_VALUE);
    }

    /**
     * Retrieves the list of racers participating in the simulation.
     * This includes all racers regardless of whether they have finished the race.
     * 
     * @return An unmodifiable list of all racers in the simulation
     */
    public List<Racer> getRacers() {
        return racers;
    }

    /**
     * Retrieves the track being used for this race simulation.
     * 
     * @return The track object on which the race is taking place
     */
    public Track getTrack() {
        return track;
    }

    /**
     * Retrieves the complete history of each racer's progress throughout the race.
     * This method creates a list of RacerHistory objects, each containing snapshots
     * of
     * a racer's state after each action taken by that racer. This is primarily used for
     * visualization
     * and playback of the race history.
     * 
     * Note: A racer must have a history tracker set via setHistory() before the
     * race
     * for this method to return meaningful data.
     * 
     * @return A list of RacerHistory objects, one for each racer in the simulation
     */
    public List<RacerHistory> getRacersHistories() {
        List<RacerHistory> histories = new ArrayList<>();
        for (Racer racer : racers) {
            histories.add(racer.getHistory());
        }
        return histories;
    }
}
