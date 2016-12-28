package tutoriel;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppState;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Spatial;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.BufferUtils;

import presentation.*;
import data.Test;

public class EarthTest extends SimpleApplication {

	
	
	private static final float TEXTURE_LAT_OFFSET = -0.2f;
	private static final float TEXTURE_LON_OFFSET = 2.8f;
	
	private static Vector3f geoCoordTo3dCoord(float lat,float lon){
		float lat_cor = lat + TEXTURE_LAT_OFFSET;
		float lon_cor = lon + TEXTURE_LON_OFFSET;
		return new Vector3f(- FastMath.sin(lon_cor * FastMath.DEG_TO_RAD)
							* FastMath.cos(lat_cor * FastMath.DEG_TO_RAD),
							  FastMath.sin(lat_cor * FastMath.DEG_TO_RAD),
							- FastMath.cos(lon_cor * FastMath.DEG_TO_RAD)
							* FastMath.cos(lat_cor * FastMath.DEG_TO_RAD));
	}
	
	public void displayTown(float latitude,float longtitude) {
		
		Sphere sphere = new Sphere(16,8,0.005f);
		Geometry town = new Geometry("Town",sphere);
		Vector3f position = new Vector3f();
		position = geoCoordTo3dCoord(latitude,longtitude);
		Material mat1 = new Material (assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
		mat1.setColor ("Color",ColorRGBA.Red);
		town.setMaterial(mat1);
		town.setLocalTranslation(position);
		rootNode.attachChild(town);
	}
	
	public void displayRoute(float latitude1,float longtitude1,float latitude2,float longtitude2){
		
		Vector3f[] vertices = new Vector3f[500];
		//vertices[0] = geoCoordTo3dCoord(latitude1,longtitude1);
		//vertices[49] = geoCoordTo3dCoord(latitude2,longtitude2);
		for(int i = 0;i<500; i++){
			float t = (float) ((float)i*Math.PI*(longtitude2-longtitude1)/(180*500));
			float lantitude = latitude1+i*(latitude2-latitude1)/500;
			float longtitude ;
			
			longtitude = longtitude1+i*(longtitude2-longtitude1)/500;
			vertices[i] = new Vector3f();
			vertices[i] = geoCoordTo3dCoord(lantitude, longtitude);
		}
		
		
		//draw a line by using the point stored in the vertices table 
		Mesh lineMesh = new Mesh();
		
		lineMesh.setMode(Mesh.Mode.LineStrip); //set the mode
		lineMesh.setBuffer(VertexBuffer.Type.Position,3,BufferUtils.createFloatBuffer(vertices));
		lineMesh.updateBound();
		lineMesh.setLineWidth(2.0f);
		
		Geometry lineGeo = new Geometry("lineGeo",lineMesh);
		Material mat = new Material (assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Yellow);
		lineGeo.setMaterial(mat);
		rootNode.attachChild(lineGeo);
		
	}


	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		
		
		
		
		assetManager.registerLocator("earth.zip", ZipLocator.class);
		Spatial earth_geom = assetManager.loadModel("Sphere.mesh.xml");
		
		rootNode.attachChild(earth_geom);
		
		
		viewPort.setBackgroundColor(new ColorRGBA(0.1f,0.1f,0.1f,1.0f));
		/* -------- Camera settings here----------*/
		flyCam.setEnabled(false);    //disable the default cam
		
		//Enable a chase cam for a target (typically the player)
		ChaseCamera chaseCam = new ChaseCamera(cam, earth_geom,inputManager);
		chaseCam.setDragToRotate(true);
		
		//Parameterize the camera motion
		//chaseCam.setInvertVerticalAxis(true);
		chaseCam.setRotationSpeed(10.0f);
		chaseCam.setMinVerticalRotation((float) -(Math.PI/2 - 0.0001f));
		chaseCam.setMaxVerticalRotation((float) (Math.PI));
		chaseCam.setMinDistance(0.35f);
		chaseCam.setMaxDistance(30.0f);
		
		
		for (int i = 0; i < MyService.trouveleaveairport.size() ; i++) {
			String lanString1 = MyService.trouveleaveairport.get(i).getLatitude();
			String longString1 =  MyService.trouveleaveairport.get(i).getLongitude();	
			displayTown(Float.parseFloat(lanString1),Float.parseFloat(longString1));	
			String lanString2 = MyService.trouveleftairport.get(i).getLatitude();
			String longString2 =  MyService.trouveleftairport.get(i).getLongitude();
			displayTown(Float.parseFloat(lanString2),Float.parseFloat(longString2));
			displayRoute(Float.parseFloat(lanString1),Float.parseFloat(longString1),Float.parseFloat(lanString2),Float.parseFloat(longString2));
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EarthTest earth = new EarthTest();
		//earth.displayRoute(0, 0, 0, 0);
		earth.start();
	}

}
