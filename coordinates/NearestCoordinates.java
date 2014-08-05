package audible.catalog.coordinates;

import java.util.List;
public class NearestCoordinates {

	public CoordinatePair getNearestCoordinates(List<Coordinates> coordinates){
		CoordinatePair nearest = getNearestCoordinates((Coordinates[])coordinates.toArray(), 0, coordinates.size()-1);
		return null;
	}
	
	public CoordinatePair getNearestCoordinates(Coordinates[] array, int start, int end){
		if (array == null || array.length == 0 || start > end){
			return null;
		} else if (start == end){
			return new CoordinatePair(array[start],null);
		} else if (end-start == 1){
			return new CoordinatePair(array[start],array[end]);
		} else {
			int mid = start + (end-start)/2;
			double median = 0;
			if ((end-start) % 2 == 0){
				median = array[mid].x;
			} else {
				median =(array[mid].x + array[mid-1].x)/2;
			}
			CoordinatePair leftPair = this.getNearestCoordinates(array,start,mid);
			CoordinatePair rightPair = this.getNearestCoordinates(array,mid+1, end);
			
			double minDistance = 0;
			if (leftPair.distance() != -1 && rightPair.distance() != -1){
				minDistance = leftPair.distance() > rightPair.distance() ? rightPair.distance() : leftPair.distance();
			} else {
				minDistance =  leftPair.distance() == -1  ? rightPair.distance() : -1;
			}
			if (minDistance > -1){
				List<Coordinates> coordinates = findLeftDistancePoints(median, array, start, mid);
				List<Coordinates> rightCoordinates = findRightDistancePoints(median, array,start,mid);
				// add all coordinates
				// Sort based on y coordinate.
				// Find the coordinates that has distance.
			}
		}
		return null;
	}
}
